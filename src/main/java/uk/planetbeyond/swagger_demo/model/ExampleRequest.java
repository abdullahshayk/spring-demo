package uk.planetbeyond.swagger_demo.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExampleRequest
{
	@Schema(example = "TestName")
	private String name;

	@Schema(example = "20")
	private int age;
}