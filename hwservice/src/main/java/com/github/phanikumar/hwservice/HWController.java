/**
 * 
 */
package com.github.phanikumar.hwservice;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

/**
 * @author phani kumar
 *
 */
@Slf4j
@RestController
@RequestMapping(path = "/hwservice/greeting")
public class HWController {

	@GetMapping(path = "/")
	public String greeting() {
		log.info("HW called");
		return "Hello World";
	}
}
