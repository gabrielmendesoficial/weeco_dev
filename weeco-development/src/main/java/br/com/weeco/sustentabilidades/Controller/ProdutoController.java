package br.com.weeco.sustentabilidades.Controller;

// Imports necessarios para o projeto ser conduzido
import br.com.weeco.sustentabilidades.*;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Conclui que a classe é um controlador REST
// Seleciona a URL base do controlador da API
@RestController 
@RequestMapping("/api/produto") 
public class ProdutoController {

        private List<Producer> products = new ArrayList<>(); 

        @GetMapping 
        public ResponseEntity<List<Producer>> getAllProducts() { 
            return ResponseEntity.ok(products); 
        }

        @GetMapping("/{id}") 
        public ResponseEntity<Producer> getProductById(@PathVariable Long id) {
            Optional<Producer> productOptional = products.stream().filter(p -> p.getId().equals(id)).findFirst();
            if (productOptional.isPresent()) { 
                return ResponseEntity.ok(productOptional.get()); 
            } else { 
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); 
            }
        }

        @PostMapping 
        public ResponseEntity<Producer> createProduct(@RequestBody Producer product) { 
            products.add(product); return ResponseEntity.status(HttpStatus.CREATED).body(product); 
        }

        @PutMapping("/{id}") 
        public ResponseEntity<Producer> updateProduct(@PathVariable Long id, @RequestBody Producer product) {
            for (int i = 0; i < products.size(); i++) { 
                if (products.get(i).getId().equals(id)) { 
                    products.set(i, product); 
                    return ResponseEntity.ok(product);
                } 
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        @DeleteMapping("/{id}") 
        public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
            for (int i = 0; i < products.size(); i++) { 
                if (products.get(i).getSsl().equals(id)) { products.remove(i); return ResponseEntity.noContent().build(); }
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }