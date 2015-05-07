package rest.response;

public class JsonResponse {
	private static final String SUCCESS = "success";
	private static final String ERROR = "error";
	private Object result;
	private String status;
	private String error;
	
	private JsonResponse() {
		
	}
	
	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	public static JsonResponse success(Object result) {
		JsonResponse response = new JsonResponse();
		response.setStatus(JsonResponse.SUCCESS);
		response.setResult(result);
		return response;
	}

	public static JsonResponse error(String error) {
		JsonResponse response = new JsonResponse();
		response.setStatus(JsonResponse.ERROR);
		response.setError(error);
		return response;
	}
}
