package com.carlsonwagonlit.linedef;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

/**
 * REST Controller for LineDefs
 */
@RestController
public class LineDefController {

    @Autowired
    private LineDefRepo repo;

    @ApiOperation(value = "getLineDef", nickname = "getLineDef")
    @RequestMapping(method = RequestMethod.GET, path = "/lineDef", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = LineDef.class),
            @ApiResponse(code = 404, message = "LineDef not found")})
    public LineDef lineDef(@RequestParam String subGuidId, @RequestParam String gdsId) {
        return repo.lineDef(subGuidId, gdsId).orElseThrow(LineDefNotFound::new);
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No LineDef found")
    static class LineDefNotFound extends RuntimeException {
    }
}
