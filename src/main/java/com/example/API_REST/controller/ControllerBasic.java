package com.example.API_REST.controller;

import com.example.API_REST.models.UsuarioModel;
import com.example.API_REST.services.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class ControllerBasic {

    @Autowired
    UsuarioServices servicio;

    @GetMapping
    public String obtenerUsuarios(Model model){
        model.addAttribute("obtenerUsers",servicio.obtenerusuarios());
        superDigit("148",3);
        return "index";
    }

    public static int superDigit(String n, int k) {
        // Write your code here
        if(k==1){
            return Integer.valueOf(n);
        }else{
            int sum=0;
            for(int i=0;i<k;i++){
                String h=String.valueOf(n.charAt(i));
                sum+=Integer.valueOf(h);
            }
            k=String.valueOf(sum).length();
            return superDigit(String.valueOf(sum), k);
        }
    }

    @GetMapping("/form")
    public ModelAndView getForm(){
        return new ModelAndView("form").addObject("user",new UsuarioModel());
    }

    @GetMapping(path={"/post"})
    public ModelAndView obtenerUsuariosByID(@RequestParam(defaultValue = "1",name="id", required = false) Integer id){
        ModelAndView model=new ModelAndView("post");
        Optional<UsuarioModel> lista=servicio.obtenerPorID(id);
        model.addObject("user",lista.get());
        return model;
    }

    @PostMapping("/addNewUser")
    public String addNewUser(UsuarioModel user,Model model){
        servicio.guardarUsuario(user);
        return obtenerUsuarios(model);
        //return "index";
    }


    /*@GetMapping(path="/{id}")
    public Optional<UsuarioModel> obtenerUsuariosByID(@PathVariable("id") Integer id){
        return servicio.obtenerPorID(id);
    }

    @GetMapping("/query")
    public ArrayList<UsuarioModel> obtenerUsuariosByNombre(@RequestParam("nombre") String nombre){
        return servicio.obtenerPorPrioridad(nombre);
    }



    @PostMapping(path="/{id}")
    public void deleteUsuario(@PathVariable("id") Integer id){
        servicio.deleteUsuario(id);
    }

    @PostMapping()
    public ResponseEntity<Object> updateUsuario(@RequestBody UsuarioModel usuario, @PathVariable("id") Integer id){
        Optional<UsuarioModel>user=servicio.obtenerPorID(id);
        if(!user.isPresent()){
            return ResponseEntity.notFound().build();
        }

        user.get().setNombre(usuario.getNombre());
        user.get().setApellido(usuario.getApellido());
        user.get().setEmail(usuario.getEmail());
        user.get().setPass(usuario.getPass());
        user.get().setUser(usuario.getUser());
        return ResponseEntity.status(HttpStatus.CREATED).body(servicio.guardarUsuario(usuario));
    }*/

}
