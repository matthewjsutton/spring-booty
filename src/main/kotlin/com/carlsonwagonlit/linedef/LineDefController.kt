package com.carlsonwagonlit.linedef

import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

/**
 * REST Controller for LineDefs
 */
@RestController
class LineDefController(val repo: LineDefRepo) {

    @RequestMapping(method = arrayOf(RequestMethod.GET), path = arrayOf("/lineDef"), produces = arrayOf("application/json"))
    @ApiOperation(value = "getLineDef", nickname = "getLineDef")
    @ApiResponses(value = *arrayOf(
            ApiResponse(code = 200, message = "Success", response = LineDef::class),
            ApiResponse(code = 404, message = "LineDef not found")
    ))
    fun lineDef(@RequestParam subGuidId: String, @RequestParam gdsId: String): LineDef {
        return repo.lineDef(subGuidId, gdsId).orElseThrow({ LineDefNotFound() })
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No LineDef found")
    private class LineDefNotFound : RuntimeException()
}