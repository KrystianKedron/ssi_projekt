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
    
    public Boolean zaloguj(userForm usr){
        
        for (Iterator iterator = usersList.keySet().iterator(); iterator.hasNext();) {
            
            Object key = iterator.next();
            userForm ele = usersList.get(key);
            
            if (usr.getEmail().equals(ele.getEmail())){
                if (usr.getHaslo().equals(ele.getHaslo())) {
                    return true;
                }       
            }
        }
        
        return false;
    }
    
    @RequestMapping(value = "/logowanie", method = RequestMethod.POST)
    public ModelAndView logowanie( @RequestParam("email") String email, @RequestParam("haslo") String password) {
        System.out.println(email);
        
        ModelMap mapa = new ModelMap();
        
        user = new userForm(id, email, password);
        System.err.println(user.getEmail() + " " +user.getHaslo());
        printListUsers();
        
        String widok = "";
        if (zaloguj(user)){
            widok = "admin";
        } else {
            widok = "index";
        }
        
        mapa.put("user", user);
        
        return new ModelAndView(widok, mapa);
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
                System.out.println("User "+ usr.getEmail() + " " + usr.getHaslo() + " " + usr.getId());
            }
        }
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
}