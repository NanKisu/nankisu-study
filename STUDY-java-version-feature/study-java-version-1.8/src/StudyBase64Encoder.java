import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class StudyBase64Encoder {
	private static final String message = "안녕하세요~!";
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		Encoder base64Encoder = Base64.getEncoder();
		Decoder base64Decoder = Base64.getDecoder();
		
		String encoded_string = base64Encoder.encodeToString(message.getBytes("UTF-8"));
		byte[] decoded_string = base64Decoder.decode(encoded_string.getBytes());
		
		System.out.println(encoded_string);
		System.out.println(new String(decoded_string, "UTF-8"));
	}
}
