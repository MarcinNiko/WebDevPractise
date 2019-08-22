package com.example.bootipa.controllers;

import com.example.bootipa.dao.AlienRepo;
import com.example.bootipa.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
public class AlienController
{
    @Autowired
    AlienRepo repo;

    @RequestMapping("home")
    public ModelAndView home()
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home");
        return mv;
    }

//    @RequestMapping("/addAlien")
//    public ModelAndView addAlien(Alien alien)
//    {
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("home");
//        mv.addObject("AlienObj", alien);
//        repo.save(alien);
//        return mv;
//    }

    @RequestMapping("/getAlien")
    public ModelAndView getAlien(@RequestParam Integer aid)
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("showAlien");
        Alien alien = repo.findById(aid).orElse(new Alien());

        System.out.println(repo.findByTech("Java"));
        System.out.println(repo.findByAidGreaterThan(102));
        System.out.println(repo.findByTechSorted("Java"));

        mv.addObject(alien);
        return mv;
    }

    @GetMapping("/aliens")
    public List<Alien> showAliens()
    {
        return repo.findAll();
    }

    @RequestMapping("/alien/{aid}")
    public Optional<Alien> showAlien(@PathVariable("aid") int aid)
    {
        return repo.findById(aid);
    }

    @PostMapping("/alien")
    public Alien addAlien(@RequestBody Alien alien)
    {
        repo.save(alien);
        return alien;
    }

    @DeleteMapping("/alien/{aid}")
    public String deleteAlien(@PathVariable int aid)
    {
        Alien a = repo.getOne(aid);
        repo.delete(a);
        return "deleted";
    }

    @PutMapping(path="/alien")
    public Alien saveOrUpdateAlien(@RequestBody Alien alien)
    {
        repo.save(alien);
        return alien;
    }
}
