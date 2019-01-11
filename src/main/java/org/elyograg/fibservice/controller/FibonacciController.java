package org.elyograg.fibservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FibonacciController {

	@SuppressWarnings("rawtypes")
	@RequestMapping(value =
	{ "/", "/index.html" })
	public ResponseEntity mainPage()
	{
		
	}
}
