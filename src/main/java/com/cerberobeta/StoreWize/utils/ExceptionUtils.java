package com.cerberobeta.StoreWize.utils;

import com.cerberobeta.StoreWize.exception.APIException;
import com.cerberobeta.StoreWize.exception.RestResponseException;
import com.cerberobeta.StoreWize.exception.ResponseException;
import com.cerberobeta.StoreWize.utils.SerializerUtils;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public final class ExceptionUtils {
	private static final String REG = "\\d+\\.[\\w|-]+\\.(.*)";
	private static final Pattern REGEX_PATTERN_ERROR = Pattern.compile(REG);
	private static final Integer CODE_1 = 1;
	private static final Integer CODE_2 = 2;
	private static final Integer CODE_3 = 4;
	private static final Integer CODE_4 = 5;
	private static final Integer CODE_5 = 6;
	private static final Map<String, Integer> map = new HashMap<String, Integer>() {};
	
	private ExceptionUtils() { }

	static
	{
		map.put("400001", CODE_1);
		map.put("400002", CODE_2);
		map.put("400004", CODE_3);
		map.put("400005", CODE_4);
		map.put("400006", CODE_5);
	}
	public static void validaHttpStatusResponse(RestResponseException excep) {
		ResponseException responseException = SerializerUtils.jsonAObjeto(excep.getResponseBody(), ResponseException.class);

		int codigoError = getCodigoError(responseException.getCodigo());

		throw new APIException(codigoError, responseException.getDetalles(),
				HttpStatus.valueOf(excep.getHttpStatus()));
	}
	private static int getCodigoError(String codigoErrorIdentidad) {

		Matcher matcher = REGEX_PATTERN_ERROR.matcher(codigoErrorIdentidad);
		String codigoIdentidad = "";
		while (matcher.find()) {
			codigoIdentidad = matcher.group(1);
		}
		Integer code = map.get(codigoIdentidad);

		if (code != null) 
		{
			return code;
		} 
		else 
		{
			return 1;
		}

	}
}
