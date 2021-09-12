${copyright}

package com.accenture.digital.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;

/**
 * @author alan.yang.zhang
 *
 */
public class ServletResponseUtil {

	public static void sendFile(HttpServletResponse httpServletResponse, String fileName, File file, String contentType) {
		setHeaders(httpServletResponse, fileName, contentType);

		write(httpServletResponse, file);
	}

	public static void write(ServletResponse servletResponse, File file) {
		OutputStream outputStream = null;
		InputStream inputStream = null;

		try {
			if (servletResponse.isCommitted()) {
				return;
			}

			outputStream = servletResponse.getOutputStream();

			inputStream = new FileInputStream(file);

			IOUtils.copy(inputStream, outputStream);

			outputStream.flush();
		}
		catch (IOException ioexception) {
			ioexception.printStackTrace();
		}
		finally {
			IOUtils.closeQuietly(inputStream);

			IOUtils.closeQuietly(outputStream);
		}
	}
	
	protected static void setHeaders(HttpServletResponse httpServletResponse, String fileName, String contentType) {
		if (!contentType.equals("")) {
			httpServletResponse.setContentType(contentType);
		}

		String contentDispositionFileName = "filename=\"" + fileName + "\"";
		String contentDispositionType = "attachment;";


		StringBuilder sb = new StringBuilder(3);

		sb.append(contentDispositionType);
		sb.append(" ");
		sb.append(contentDispositionFileName);

		httpServletResponse.setHeader(
			HttpHeaders.CONTENT_DISPOSITION, sb.toString());

		httpServletResponse.setBufferSize(4096);
	}

	protected static void setContentLength(
		HttpServletResponse httpServletResponse, int contentLength) {

		httpServletResponse.setContentLength(contentLength);
	}

}
