package org.elyograg.fibservice.util;

/**
 * A class containing constants and methods for dealing with commonly needed
 * HTML text.
 */
public class CommonHtmlBits {
	/*
	 * Hoping that the java compiler will optimize away the string concatenation
	 * utilized here, since string concatenation is not the fastest way to create
	 * strings.
	 */

	/** A constant for a newline character. */
	public static final String NL = "\n";

	/** A constant for a double quote. */
	public static final String DQ = "\"";

	/**
	 * Appends a DOCTYPE indicating XHTML Strict, an opening html tag, a full head
	 * with the included page title, and an opening body tag to the referenced
	 * {@link StringBuilder}. Includes a meta tag defining the type as text/html,
	 * and charset as utf-8.
	 * 
	 * @param sb        The {@link StringBuilder} to append to.
	 * @param pageTitle The page title to use.
	 */
	public synchronized static void appendStrictXhtmlPageBegin(StringBuilder sb, String pageTitle) {
		sb.append("<!DOCTYPE html PUBLIC " + DQ + "-//W3C//DTD XHTML 1.0 Strict//EN" + DQ + NL);
		sb.append(DQ + "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd" + DQ + ">" + NL);
		sb.append("<html xmlns=" + DQ + "http://www.w3.org/1999/xhtml" + DQ + ">" + NL);
		sb.append("<head>" + NL);
		sb.append("  <meta http-equiv=" + DQ + "Content-Type" + DQ + " content=" + DQ + "text/html; charset=utf-8" + DQ
				+ "/>" + NL);
		sb.append("  <title>");
		sb.append(pageTitle);
		sb.append("</title>" + NL);
		sb.append("<body>" + NL);
	}

	/**
	 * Appends body close and html close tags to the referenced
	 * {@link StringBuilder}.
	 * 
	 * @param sb The {@link StringBuilder} to append to.
	 */
	public synchronized static void appendBodyHtmlEnd(StringBuilder sb) {
		sb.append("</body>" + NL);
		sb.append("</html>" + NL);
	}
}
