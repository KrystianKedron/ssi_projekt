package pk.ssi;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pk.ssi.hibernate.DataBase;

@RequestMapping("/main")
@Controller
public class usersController {
    
    Map<Integer, userForm> usersList = new HashMap<Integer, userForm>();
    userForm user = new userForm();
    DataBase dat = new DataBase();
    static int id = 0;
    static private boolean init = false;
    administratorForm admin = new administratorForm();
    List<zadanieForm> ListaZadan = new ArrayList<zadanieForm>();
    List<pracownikForm> ListaPracownikow = new ArrayList<pracownikForm>();
    
    
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView zapisz(@ModelAttribute("user") @Valid userForm usr, BindingResult errors, 
            HttpServletRequest request, HttpServletResponse response){
        
        if (errors.hasErrors()){
            
            ModelMap _mapa = new ModelMap();
            _mapa.put("user", usr);
            _mapa.put(BindingResult.class.getName(), errors);
            ModelAndView form = new ModelAndView("rejestracja", _mapa);
            return form;
        }
        
        if (usr.getId() == -1){
            id++;
            usr.setId(id);
            usersList.put(id, usr);
        }else{
            
            usersList.put(usr.getId(), usr);
        }
        
        dat.addUser(usr.getId(), usr.getEmail(), usr.getHaslo());
        
        ModelMap mapa = new ModelMap();
        mapa.put("user", usr);
        
        return  new ModelAndView("index", mapa);
    }
    
    @RequestMapping(value = "/rejestracja", method = RequestMethod.GET)
    public ModelAndView nowyUser(){
        
        userForm stud = new userForm();
        ModelMap mapa = new ModelMap();
        mapa.put("user", stud);
        
        return new ModelAndView("rejestracja", mapa);
    }
    
    private String parser(String string){
        
        String value = "";
        for (char c : string.toCharArray()) {
            if (c != ' '){
                value += c;
            }
        }
        
        return value;
    }
    
    public Boolean zaloguj(){
        
        System.out.println("Weszlo zaloguj");
        for (Iterator iterator = usersList.keySet().iterator(); iterator.hasNext();) {
            
            Object key = iterator.next();
            userForm ele = usersList.get(key);
            // parsowanie elementow
            String email = parser(ele.getEmail());
            String haslo = parser(ele.getHaslo());
            System.out.println("ODCZYTANE" + email + " " + haslo);
            if (user.getEmail().equals(email)){
                if (user.getHaslo().equals(haslo)) {
                    user.setId(ele.getId());
                    System.out.println("ID USR " + user.getId());
                    return true;
                }       
            }
        }
        
        return false;
    }
    
    public void createTasksObjects(){
        
        ListaZadan.clear();
        
        String[][] zadaniaData = dat.searchFreeTask();   
        for (String[] ele : zadaniaData) {
            ListaZadan.add(new zadanieForm(Integer.valueOf(ele[0]),0,
                    ele[1],Integer.valueOf(ele[2]),Integer.valueOf(ele[3])));
        }
    }
    
    public void createAdminObject(){
        
        String[] data = dat.searchId(String.valueOf(user.getId()));
        admin = new administratorForm(Integer.valueOf(data[0]),
                                      Integer.valueOf(data[1]),
                                      data[2], data[3]);
    }
    
    public void createWorkersObjects(){
        
        ListaPracownikow.clear();
        
        String[][] pracownicyData = dat.searchAllEmployers();
        for (String[] ele : pracownicyData) {
            ListaPracownikow.add(new pracownikForm(Integer.valueOf(ele[0])
                    ,0, ele[1],ele[2]));
        }
    }
    
    public void putDataToMap(ModelMap mapa){
        
        mapa.put("admin", admin);
        mapa.put("zadania", ListaZadan);
        mapa.put("pracownicy", ListaPracownikow);
        mapa.put("aktywne", dat.searchActiveTaskt());
        zadaniaHelper przydziel = new zadaniaHelper();
        mapa.put("przydziel", przydziel);
    }
    
    @RequestMapping(value = "/logowanie", method = RequestMethod.POST)
    public ModelAndView logowanie( @RequestParam("email") String email, @RequestParam("haslo") String password) {
        
        ModelMap mapa = new ModelMap();
        
        user = new userForm(id, email, password);
        
//        System.out.println(id);
//        System.err.println(user.getEmail() + " " +user.getHaslo());
//        printListUsers();
        
        String widok = "";
        if (zaloguj()){
            createAdminObject();
            widok = "admin";
        } else {
            //stworzenie oblugi bledow
            widok = "index";
            mapa.put("user", user);
        }
        
        if (admin.getId() != -1){
            
            createTasksObjects();
            createWorkersObjects();
            putDataToMap(mapa);
        } 
//        System.out.println(widok);
        
        return new ModelAndView(widok, mapa);
    }
    
    @RequestMapping(value = "/dodaj", method = RequestMethod.POST)
    public ModelAndView dodajZadanie(@ModelAttribute("przydziel") zadaniaHelper przydziel) throws Exception {

        System.out.println("Przekazano " + przydziel.getZadanie() + " " + przydziel.getPracownik());
        
        dat.assignTask(przydziel.getPracownik(), przydziel.getZadanie());
        createTasksObjects();
        
        ModelMap mapa = new ModelMap();
        putDataToMap(mapa);
        
        return new ModelAndView("admin", mapa);
    }
    
    private void getDataBaseData(){
        
        usersList = dat.getAllUsers();
        printListUsers();
        id = usersList.size();
        init = true;
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView wyswietl(HttpServletRequest request){
        
        if (init == false){
            
            getDataBaseData();
            user.setId(-1);
            admin.setId(-1);
        }
        
        ModelMap mapa = new ModelMap();
        mapa.put("user", user);
        
        return new ModelAndView("index", mapa);
    }
    
    private List<userForm> upadteListUsers(){
        Iterator iter = usersList.keySet().iterator();
        List<userForm> nowaMapa = new ArrayList<userForm>();
        
        while (iter.hasNext()) {
            Object key = iter.next();
            if (key!=null)
                nowaMapa.add(usersList.get(key));
        }
        
        return nowaMapa;
    }
    
    private void printListUsers(){
        
        Iterator iter = usersList.keySet().iterator();
        userForm usr;
        while (iter.hasNext()) {
            Object key = iter.next();
            if (key!=null){
                usr = (userForm) usersList.get(key);
                System.out.println("User "+ String.valueOf(usr.getEmail().length()) + usr.getEmail() + " " + String.valueOf(usr.getHaslo().length())  + usr.getHaslo() + " " + usr.getId());
            }
        }
    }
    
    @RequestMapping(value="/usun/{opis}", method = RequestMethod.GET)
    public ModelAndView usun(@PathVariable String opis, HttpServletRequest request){
        
        System.out.println(opis);
        
        dat.deleteTask(opis);
        
        ModelMap mapa = new ModelMap();
        putDataToMap(mapa);
        
        return new ModelAndView("admin", mapa);
    }
    
//    @RequestMapping(value="/usun/{id}", method = RequestMethod.POST)
//    public String usun(@PathVariable String id, HttpServletRequest request){
//        
//        userForm ele = usersList.get(Integer.parseInt(id));
//        dat.delete(ele.getId(), ele.getImie(), ele.getNazwisko());
//        
//        usersList.remove(Integer.parseInt(id));
//        
//        Iterator iter = usersList.keySet().iterator();
//        List<userForm> nowaMapa = new ArrayList<userForm>();
//        
//        while (iter.hasNext()) {
//            Object key = iter.next();
//            if (key!=null)
//                nowaMapa.add(usersList.get(key));
//        }
//        
//        request.setAttribute("users", nowaMapa);
//        
//        return "pokaz";
//    }
//    
    @ExceptionHandler(value=NullPointerException.class)
    public ModelAndView handleNullPointerExeption(HttpServletRequest req, Exception e){
        
        ModelAndView mav = new ModelAndView();
        
//        mav.addObject("exception", e);
//        mav.addObject("url", req.getRequestURL());
        mav.setViewName("errorPage");
        return mav;
    }
        
//    @RequestMapping(value = "/edytuj/{id}", method = RequestMethod.POST)
//    public ModelAndView edytuj(@PathVariable String id) throws Exception{
//        
//        ModelMap mapa = new ModelMap();
//               
//        userForm _usr = usersList.get(Integer.parseInt(id));
//        
//        if (_usr != null){
//            mapa.put("users", usersList.get(Integer.parseInt(id)));
//        } else {
//            throw new NullPointerException("Null pointer exeption");
//        }
//        
//        return new ModelAndView("user", mapa);
//    }
    @RequestMapping(value = "/cennik", method = RequestMethod.GET)
    public ModelAndView createCennik(){
//        ModelMap mapa = new ModelMap();
        return new ModelAndView("cennik");
    }
    
    @RequestMapping(value = "/ustawienia", method = RequestMethod.GET)
    public ModelAndView createUstawienia(){
//        ModelMap mapa = new ModelMap();
        return new ModelAndView("ustawienia");
    }
    
    @RequestMapping(value = "/pracownik/{id}")
    public ModelAndView przydziel(@PathVariable String id, HttpServletRequest request){
        
        ModelMap mapa = new ModelMap();
        
        dat.addWorker(id);
        createWorkersObjects();
        mapa.put("users", dat.getUsers());
        
        putDataToMap(mapa);
        
        return new ModelAndView("redirect:/main/uzytkownicy", mapa);
    }
    
    @RequestMapping(value = "/uzytkownicy", method = RequestMethod.GET)
    public ModelAndView createUzytkownicy(){
        
        ModelMap mapa = new ModelMap();
        createWorkersObjects();
        mapa.put("pracownicy", ListaPracownikow);
        mapa.put("users", dat.getUsers());
        mapa.put("admin", admin);
        
        return new ModelAndView("uzytkownicy", mapa);
    }
    
    @RequestMapping(value = "/przydziel_zadania", method = RequestMethod.GET)
    public ModelAndView createPrzydziel_zadania(){
//        ModelMap mapa = new ModelMap();
        return new ModelAndView("przydziel_zadania");
    }
    
    @RequestMapping(value = "/pracownik_grafik", method = RequestMethod.GET)
    public ModelAndView createPracownik_grafik(){
//        ModelMap mapa = new ModelMap();
        return new ModelAndView("pracownik_grafik");
    }
    
    @RequestMapping(value = "/pracownik_zadania", method = RequestMethod.GET)
    public ModelAndView createPracownik_zadania(){
//        ModelMap mapa = new ModelMap();
        return new ModelAndView("pracownik_zadania");
    }
    
    @RequestMapping(value = "/klient_cennik", method = RequestMethod.GET)
    public ModelAndView createKlient_cennik(){
//        ModelMap mapa = new ModelMap();
        return new ModelAndView("klient_cennik");
    }
    @RequestMapping(value = "/klient_dane", method = RequestMethod.GET)
    public ModelAndView createKlient_dane(){
//        ModelMap mapa = new ModelMap();
        return new ModelAndView("klient_dane");
    }
    @RequestMapping(value = "/klient_status", method = RequestMethod.GET)
    public ModelAndView createKlient_status(){
//        ModelMap mapa = new ModelMap();
        return new ModelAndView("klient_status");
    }
    @RequestMapping(value = "/klient_usluga", method = RequestMethod.GET)
    public ModelAndView createKlient_usluga(){
//        ModelMap mapa = new ModelMap();
        return new ModelAndView("klient_usluga");
    }
    
    
}