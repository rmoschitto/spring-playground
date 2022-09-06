package com.galvanize.demo.cats;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatController {

//    @GetMapping("/cats")
//    public String getSpecificCats(@RequestParam String name, @RequestParam String color){
//        return String.format("The name of the cat is %s and it is a %s.", name, color);
//    }

    //Creating a POJO Plain old Java Object
    @GetMapping("/cats")
    public String getSpecificCats(Cat newCat){
        return String.format("The name of the cat is %s and it is a %s.", newCat.getName(), newCat.getColor());
    }

    @GetMapping("/cats/{catId}")
    public String getCatById(@PathVariable String catId){
        return "This is cat number " + catId;
    }



    /*

    ////// Cat Controller //////////
package com.galvanize.springplayground.cats;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
@RestController
public class CatController {
    @GetMapping("/cats")
    public String getSpecificCats(@RequestParam String name, @RequestParam( required = false) String color) {
        return String.format("The name of the cat is %s and it is a %s", name, color);
    }
    @GetMapping("/cats")
    public String getSpecificCat(@RequestParam Map<String,String> queryString) {
//        return String.format("The name of the cat is %s and it is a %s", queryString.get("name"), queryString.get("color"));
    }
//    @GetMapping("/cats")
//    public String getSpecificCats(Cat newCat) {
//
//        return String.format("The name of the cat is %s and it is a %s", newCat.getName(), newCat.getColor());
//
//    }
}
////////Cat Class /////////
package com.galvanize.springplayground.cats;
public class Cat {
    private String name;
    private String color;
    public String getColor() {
        return color;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setColor(String color) {
        this.color = color;
    }
}
/////// Cat Tests ///////////
package com.galvanize.springplayground.cats;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@WebMvcTest
public class CatControllerTests {
    @Autowired
    MockMvc mvc;
    @Test
    void getCatsReturnsNameOfCat() throws Exception{
        this.mvc.perform(get("/cats?name=fluffy&color=tabby"))
                .andExpect(status().isOk())
                .andExpect(content().string("The name of the cat is fluffy and it is a tabby"));
        this.mvc.perform(get("/cats?name=midnight&color=black"))
                .andExpect(status().isOk())
                .andExpect(content().string("The name of the cat is midnight and it is a black"));
        this.mvc.perform(get("/cats?name=midnight"))
                .andExpect(status().isOk())
                .andExpect(content().string("The name of the cat is midnight and it is a brown"));
    }
}
////// Dog Path Variable Example ///////
@GetMapping("/dogs/{dogId}")
    public String getDogById(@PathVariable String dogId) {
    return "This is dog number " + dogId;
}


     */
}
