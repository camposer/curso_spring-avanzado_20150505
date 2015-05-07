package rest.response;

public class JsonResponse<E> {
	public static final String SUCCESS = "success";
	public static final String ERROR = "error";
	private E result;
	private String status;
	private String error;
	
	public JsonResponse() {
		
	}
	
	public JsonResponse(String status, E result) {
		this.result = result;
		this.status = status;
	}

	public JsonResponse(String status, String error) {
		this.status = status;
		this.error = error;
	}

	public E getResult() {
		return result;
	}

	public void setResult(E result) {
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
}
