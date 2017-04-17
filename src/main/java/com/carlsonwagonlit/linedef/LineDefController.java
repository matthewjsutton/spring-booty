package com.carlsonwagonlit.linedef;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
