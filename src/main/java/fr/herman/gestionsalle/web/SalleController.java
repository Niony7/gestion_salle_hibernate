package fr.herman.gestionsalle.web;

import fr.herman.gestionsalle.entities.Prof;
import fr.herman.gestionsalle.entities.Salle;
import fr.herman.gestionsalle.metier.IProfMetier;
import fr.herman.gestionsalle.metier.ISalleMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SalleController {
    @Autowired
    ISalleMetier salleMetier;

    @GetMapping("/salles")
    public String getAllSalle(Model model){
        try{
            List<Salle> list = salleMetier.getAllSalle();
            model.addAttribute("salle",list);
        }catch (Exception e){
            model.addAttribute("exception",e);
        }
        return "salle";
    }
    @GetMapping("/addsalle")
    public String showSignSaveSalleForm(Salle salle){
        return "ajoutsalle";
    }
    @PostMapping("/savesalle")
    public String saveSalle( Salle salle, BindingResult result, Model model){
        try {
            if (result.hasErrors()){
                return "ajoutsalle";
            }
            if(salle.getCodesal().equals("")) {
                System.out.println("Donnée vide");
                return "ajoutsalle";
            }else{
                Salle s = salleMetier.saveSalle(salle);
                return "redirect:/salles";
            }

        }catch (Exception e){
            e.printStackTrace();
            model.addAttribute("exception",e);
            return "ajoutsalle";
        }
    }

    @GetMapping("/editersalle/{codesal}")
    public String showSignUdateSalleForm(@PathVariable("codesal") String codesal,Model model){
        Salle salle = salleMetier.getSalle(codesal);
        model.addAttribute("salle",salle);
        return "editersalle";
    }
    @PostMapping("/updatesalle/{codesal}")
    public String updateSalle(@PathVariable("codesal") String codesal, Salle salle, BindingResult result, Model model){
        try {
            if (result.hasErrors()){
                salle.setCodesal(codesal);
                return "editersalle";
            }
            Salle s = salleMetier.saveSalle(salle);
            return "redirect:/salles";
        }catch (Exception e){
            e.printStackTrace();
            model.addAttribute("exception",e);
            return "editersalle";
        }
    }
    @GetMapping("/supprimsalle/{codesal}")
    public String deleteProf(@PathVariable("codesal") String codesal,Model model){
        try{
            Salle s= salleMetier.getSalle(codesal);
            boolean resp = salleMetier.deleteSalle(s);
            return "redirect:/salles";
        }catch (Exception e){
            return "salle";
        }
    }
}
