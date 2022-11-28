
package com.projeto.funcionario.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.projeto.funcionario.Model.Funcionario;
import com.projeto.funcionario.Repository.FuncionarioRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/funcionario")

@AllArgsConstructor

public class FuncionarioController {

          FuncionarioRepository funcionarioRepository;

          @GetMapping
          public List<Funcionario>getAllFunciorio() {
              return  funcionarioRepository.findAll();
          }


          @GetMapping("/{id}")
          public Optional<Funcionario> getfuncioarioById(@PathVariable("id") Long id) {
              return funcionarioRepository.findById(id);
          }

          @PostMapping
          @ResponseStatus(code = HttpStatus.CREATED) 
          public Funcionario create (@RequestBody Funcionario funcionario) {
              return funcionarioRepository.save(funcionario);
          }

                            
          @PutMapping("/{id}")
          Optional<Funcionario> update(@RequestBody Funcionario newFun, @PathVariable Long id) {
          funcionarioRepository.save(newFun);     
              return funcionarioRepository.findById(id);

          }

            @DeleteMapping("/{id}")
            public void delete(@PathVariable Long id) {
            funcionarioRepository.deleteById(id);
            
          }
      
      }
    
          

