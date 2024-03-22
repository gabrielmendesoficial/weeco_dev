package br.com.weeco.sustentabilidades.View;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/login")
public class LoginView {

    @PostMapping
    public ResponseEntity<Void> login(@RequestBody Credentials credentials) {
        // Verifique as credenciais de login
        if (credentials.getUsername().equals("admin") && credentials.getPassword().equals("password")) {
            // Crie um token de autenticação ou verifique se as credenciais estão corretas em um serviço de autenticação
            return ResponseEntity.ok().build(); // Retorna uma resposta HTTP 200 OK
        } else {
            // Retorne uma resposta HTTP 401 os dados estiverem incorretos
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

   
    private static class Credentials{
        private String username;
        private String password;
    
        public String getUsername(){
            if(username == null || username.isEmpty()){
                throw new RuntimeException("Username não localizado.");
            }
            return username;
        }
    
        public void setUsername(String username){
            this.username = username;
        }
    
        public String getPassword(){
            if(password == null || password.isEmpty()){
                throw new RuntimeException("Senha não localizada");
            }
            return password;
        }
    
        public void setPassword(String password){
            this.password = password;
        }
    }
    
    @PostMapping
    public ResponseEntity<Void> login(@RequestBody Credentials credentials){
        if(credentials == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); // Retorna uma resposta HTTP 400 Bad Request
        }
        // Verifique as credenciais de login
        if (credentials.getUsername().equals("admin") && credentials.getPassword().equals("password")){
            // Crie um token de autenticação ou verifique se as credenciais estão corretas em um serviço de autenticação
            return ResponseEntity.ok().build(); // Retorna uma resposta HTTP 200 OK
        } else{
            // Retorne uma resposta HTTP 401 os dados estiverem incorretos
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}