package mgr.security;

import javax.servlet.http.HttpServletRequest;

public class EncodeLoginTransaction extends com.d_project.qrcode.web.QRCodeServlet{

	private static final long serialVersionUID = 522663020705720161L;

	@Override
	public String EncodeData(HttpServletRequest request) {
		
		return String.format("%s://%s:%s%s/%s;jsessionid=%s", request.getScheme(), request.getServerName(), request.getServerPort(), request.getContextPath(), "index.html", request.getSession(false) != null ? request.getSession(false).getId() : "");
	}

}
