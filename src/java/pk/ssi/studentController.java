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
import org.springframework.web.servlet.ModelAndView;

import pk.ssi.hibernate.Database;

@RequestMapping("/student")
@Controller
public class studentController {
    
    Map<Integer, studentForm> studentList = new HashMap<Integer, studentForm>();
    Database dat = new Database();
    static int id = 0;
    static private boolean init = false;
    
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView zapisz(@ModelAttribute("student") @Valid studentForm stud, BindingResult errors, 
            HttpServletRequest request, HttpServletResponse response){
        
        if (errors.hasErrors()){
            
            ModelMap _mapa = new ModelMap();
            _mapa.put("student", stud);
            _mapa.put(BindingResult.class.getName(), errors);
            ModelAndView form = new ModelAndView("student", _mapa);
            return form;
        }
        
        if (stud.getId() == -1){
            id++;
            stud.setId(id);
            studentList.put(id, stud);
        }else{
            
            studentList.put(stud.getId(), stud);
        }
        
        ModelMap mapa = new ModelMap();
        Iterator iter = studentList.keySet().iterator();
        List<studentForm> nowaMapa = new ArrayList<studentForm>();
        
        while (iter.hasNext()) {
            Object key = iter.next();
            if (key!=null)
                nowaMapa.add(studentList.get(key));
        }
        
        dat.addStudent(stud.getId(), stud.getImie(), stud.getNazwisko(), stud.getUczelnia());
        
        mapa.put("studenci", nowaMapa);
        
        return  new ModelAndView("pokaz", mapa);
    }
    
    @RequestMapping(value = "/nowy", method = RequestMethod.GET)
    public ModelAndView nowyStudent(){
        
        studentForm stud = new studentForm();
        ModelMap mapa = new ModelMap();
        mapa.put("student", stud);
        return new ModelAndView("student", mapa);
    }
    
    private void getDataBaseData(){
        
        studentList = dat.getAllStudents();
        id = studentList.size();
        init = true;
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String wyswietl(HttpServletRequest request){
        
        if (init == false){
            getDataBaseData();
        }
        
        String widok = "";
        Iterator iter = studentList.keySet().iterator();
        List<studentForm> nowaMapa = new ArrayList<studentForm>();
        
        while (iter.hasNext()) {
            Object key = iter.next();
            if (key!=null)
                nowaMapa.add(studentList.get(key));
        }
        
        request.setAttribute("studenci", nowaMapa);
        widok = "index";
        
        return widok;
    }
    
    @RequestMapping(value="/usun/{id}", method = RequestMethod.POST)
    public String usun(@PathVariable String id, HttpServletRequest request){
        
        studentForm ele = studentList.get(Integer.parseInt(id));
        dat.delete(ele.getId(), ele.getImie(), ele.getNazwisko(), ele.getUczelnia());
        
        studentList.remove(Integer.parseInt(id));
        
        Iterator iter = studentList.keySet().iterator();
        List<studentForm> nowaMapa = new ArrayList<studentForm>();
        
        while (iter.hasNext()) {
            Object key = iter.next();
            if (key!=null)
                nowaMapa.add(studentList.get(key));
        }
        
        request.setAttribute("studenci", nowaMapa);
        
        return "pokaz";
    }
    
    @ExceptionHandler(value=NullPointerException.class)
    public ModelAndView handleNullPointerExeption(HttpServletRequest req, Exception e){
        
        ModelAndView mav = new ModelAndView();
        
//        mav.addObject("exception", e);
//        mav.addObject("url", req.getRequestURL());
        mav.setViewName("errorPage");
        return mav;
    }
        
    @RequestMapping(value = "/edytuj/{id}", method = RequestMethod.POST)
    public ModelAndView edytuj(@PathVariable String id) throws Exception{
        
        ModelMap mapa = new ModelMap();
               
        studentForm _studentForm = studentList.get(Integer.parseInt(id));
        
        if (_studentForm != null){
            mapa.put("student", studentList.get(Integer.parseInt(id)));
        } else {
            throw new NullPointerException("Null pointer exeption");
        }
        
        return new ModelAndView("student", mapa);
    }
}