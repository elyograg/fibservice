package org.elyograg.fibservice.util;

import org.springframework.http.ResponseEntity;

/**
 * A class with static resources for the whole program.
 */
public class Common {
	/**
	 * An empty response object for OK (200).
	 */
	public static final ResponseEntity<Void> emptyResponseOK = ResponseEntity.ok().build();

	/**
	 * An empty response object for Bad Request (400).
	 */
	public static final ResponseEntity<Void> emptyResponseBadRequest = ResponseEntity.badRequest().build();

	/**
	 * An empty response object for Not Found (404).
	 */
	public static final ResponseEntity<Void> emptyResponseNotFound = ResponseEntity.notFound().build();

	/**
	 * An empty response object for Server Error (500).
	 */
	public static final ResponseEntity<Void> emptyResponseServerError = ResponseEntity.status(500).build();

}
