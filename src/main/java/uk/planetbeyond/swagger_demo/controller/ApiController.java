package uk.planetbeyond.swagger_demo.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.planetbeyond.swagger_demo.model.ExampleRequest;

@RestController
@RequestMapping("/api")
public class ApiController
{

	@GetMapping("/example-sucess")
	@Operation(summary = "Get api with ok response")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successful response"), @ApiResponse(responseCode = "404", description = "Not found"), })
	public ResponseEntity<String> getExample_success()
	{
		return ResponseEntity.status(HttpStatus.OK).body("Example found");
	}

	@GetMapping("/example-not-found")
	@Operation(summary = "Get api with not found response")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successful response"), @ApiResponse(responseCode = "404", description = "Not found"), })
	public ResponseEntity<String> getExample_error()
	{
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Example not found"); // Simulating 404 response
	}

	@PostMapping("/create-example")
	@Operation(summary = "Create Example", description = "Endpoint to create a new example")
	public ResponseEntity<String> createExample(@RequestBody ExampleRequest request)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body("Example created");
	}
}