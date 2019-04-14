package jim.pers.jerp.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping(value = "/ftl")
public class FreeMarkerController {
    @RequestMapping(value = "index")
    public Mono<String> index(final Model map){
        map.addAttribute("name","Hello World!!!");
        return Mono.just("index");
    }
}
