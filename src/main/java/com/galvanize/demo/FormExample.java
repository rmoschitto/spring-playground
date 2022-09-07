//package com.galvanize.demo;
//
//        import org.springframework.http.MediaType;
//        import org.springframework.web.bind.annotation.*;
//        import java.util.Map;
//
//@RestController
//@RequestMapping("/rb")
//public class FormExample {
//
//    //Access request body as a String
//    //Say you were building an endpoint to handle HTTP requests like this one:
//    @PostMapping("/string-example")
//    public String getRawString(@RequestBody String rawBody) {
//        return rawBody;
//    }
//
//    //Access request body as a Map
//    //A slightly more useful way to process form parameters is to turn them into a Map, like so:
//    @PostMapping(path = "/people")
//    public String showFormData(@RequestParams Map<String, String> body) {
//        return body.toString();  // {first_name=Dwayne, last_name=Johnson}
//    }
//
//    //Access request body as an object
//    //And, like you've seen before, you can also indicate to Spring that you'd like access to the form data as a typed object, like so:
//    @PostMapping(path = "/people")
//    public String showFormDataObject(@RequestBody Person person) {
//        return person.toString();
//    }
//
//    @PostMapping("/individual-example")
//    public String getIndividualParams(@RequestParam String from, @RequestParam("q") String query) {
//        return String.format("q:%s from:%s", query, from);
//    }
//
//    @PostMapping(value = "/map-example", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
//    public String getMapParams(@RequestParam Map<String, String> formData) {
//        return formData.toString();
//    }
//
//    @PostMapping(value = "/object-example", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
//    public String getObjectParams(@RequestBody Search search) {
//        return search.toString();
//    }
//
//    @PostMapping("/string-example")
//    public String getRawString(@RequestBody String rawBody) {
//        return rawBody;
//    }
//
//    @PostMapping("/posts/{postId}/comments")
//    public String createComment(@PathVariable int postId, @RequestParam Map<String, String> params) {
//        return String.format(
//                "postId:%d notify:%s content:%s author:%s",
//                postId,
//                params.get("notify"),
//                params.get("content"),
//                params.get("author")
//        );
//    }
//
//}