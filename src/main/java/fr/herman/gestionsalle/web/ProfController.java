package fr.herman.gestionsalle.web;

import fr.herman.gestionsalle.entities.Prof;
import fr.herman.gestionsalle.metier.IProfMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class ProfController {
    @Autowired
    IProfMetier profMetier;

    @GetMapping("/profs")
    public String getAllProf(Model model){
        try{
            List<Prof> list = profMetier.getAllProf();
            model.addAttribute("profs",list);
        }catch (Exception e){
            model.addAttribute("exception",e);
        }
        return "prof";
    }
    @GetMapping("/addprof")
    public String showSignSaveProfForm(Prof prof){
        return "ajoutprof";
    }
    @PostMapping("/saveprof")
    public String saveProf( Prof prof, BindingResult result, Model model){
        try {
            if (result.hasErrors()){
                return "ajoutprof";
            }
            if(prof.getCodeprof().equals("")) {
                System.out.println("Donnée vide");
                return "ajoutprof";
            }else{
                Prof p = profMetier.saveProf(prof);
                return "redirect:/profs";
            }

        }catch (Exception e){
            e.printStackTrace();
            model.addAttribute("exception",e);
            return "ajoutprof";
        }
    }

    @GetMapping("/editerprof/{codeprof}")
    public String showSignUdateProfForm(@PathVariable("codeprof") String codeprof,Model model){
        Prof prof = profMetier.getProf(codeprof);
        model.addAttribute("prof",prof);
        return "editerprof";
    }
    @PostMapping("/updateprof/{codepro}")
    public String updateProf(@PathVariable("codepro") String codepro, Prof prof, BindingResult result, Model model){
        try {
            if (result.hasErrors()){
                prof.setCodeprof(codepro);
                return "editerprof";
            }
            Prof p = profMetier.saveProf(prof);
            return "redirect:/profs";
        }catch (Exception e){
            e.printStackTrace();
            model.addAttribute("exception",e);
            return "editerprof";
        }
    }
    @GetMapping("/supprimprof/{codeprof}")
    public String deleteProf(@PathVariable("codeprof") String codeprof,Model model){
        try{
            Prof p = profMetier.getProf(codeprof);
            boolean resp = profMetier.deleteProf(p);
            return "redirect:/profs";
        }catch (Exception e){
            return "prof";
        }
    }
}
