${copyright}

package com.accenture.digital.common.utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.http.ParseException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * @author alan.yang.zhang
 *
 */
public class JSONDateTimeSerializer extends JsonSerializer<Date> {
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	@Override
	public void serialize(
			Date date, JsonGenerator gen, SerializerProvider provider)
		throws IOException, JsonProcessingException {

		try {
			String formattedDate = dateFormat.format(date);

			gen.writeString(formattedDate);
		}
		catch (ParseException e) {
		}

	}
}
