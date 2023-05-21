package fr.herman.gestionsalle.web;

import fr.herman.gestionsalle.entities.Occuper;
import fr.herman.gestionsalle.entities.Prof;
import fr.herman.gestionsalle.metier.IOccuperMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class OccuperController {
    @Autowired
    IOccuperMetier occuperMetier;

    @GetMapping("/occuper")
    public String getAllOccuper(Model model){
        try{
            List<Occuper> list = occuperMetier.getAllOccuper();
            System.out.println(list);
            model.addAttribute("occupers",list);
        }catch (Exception e){
            model.addAttribute("exception",e);

        }
        return "occuper";
    }
    @GetMapping("/addoccuper")
    public String showSignSaveOccuperForm(Occuper occuper){
        return "ajoutoccuper";
    }
    @PostMapping("/saveoccuper")
    public String saveOccuper( Occuper occuper, BindingResult result, Model model){
        try {
            if (result.hasErrors()){
                return "ajoutoccuper";
            }
            if(toString().valueOf(occuper.getId()).equals("")) {
                System.out.println("Donnée vide");
                return "ajoutoccuper";
            }else{

                Occuper o = occuperMetier.saveOccuper(occuper);
                return "redirect:/occuper";
            }

        }catch (Exception e){
            e.printStackTrace();
            model.addAttribute("exception",e);
            return "ajoutoccuper";
        }
    }

    @GetMapping("/editeroccuper/{id}")
    public String showSignUdateOccuperForm(@PathVariable("id") Integer id, Model model){
        Occuper occuper = occuperMetier.getOccuper(id);
        model.addAttribute("occuper",occuper);
        return "editeroccuper";
    }
    @PostMapping("/updateoccuper/{id}")
    public String updateOccuper(@PathVariable("id") Integer id, Occuper occuper, BindingResult result, Model model){
        try {
            if (result.hasErrors()){
                occuper.setId(id);
                return "editerprof";
            }
            Occuper o = occuperMetier.saveOccuper(occuper);
            return "redirect:/occuper";
        }catch (Exception e){
            e.printStackTrace();
            model.addAttribute("exception",e);
            return "editeroccuper";
        }
    }
    @GetMapping("/supprimoccuper/{id}")
    public String deleteoccuper(@PathVariable("id") Integer id, Model model){
        try{
            Occuper o = occuperMetier.getOccuper(id);
            boolean resp = occuperMetier.deleteOccuper(o);
            return "redirect:/occuper";
        }catch (Exception e){
            return "occuper";
        }
    }
}
