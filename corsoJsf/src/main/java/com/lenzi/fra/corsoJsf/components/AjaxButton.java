package com.lenzi.fra.corsoJsf.components;

import javax.faces.context.FacesContext;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;

public class AjaxButton extends HtmlAjaxCommandButton implements FraUiComponent {

	private static final String ON_MOUSE_OUT_DEFAULT_VALUE = "FEBV.onFebvButtonMouseOut(this);";
	private static final String ON_MOUSE_OVER_DEFAULT_VALUE = "FEBV.onFebvButtonMouseOver(this);";
	private static final String EVENTS_QUEUE_DEFAULT_VALUE = "mainProcessQueue";
	private static final String IMAGE_LEVEL_DEFAULT_VALUE = "b1";

	private String _imageToken = null;
	private String _imageLevel = null;

	@Override
	public String getEventsQueue() {
		return new PropertyResolver<String>(this, "eventsQueue")
				.fieldValue(super.getEventsQueue())
				.defaultValue(EVENTS_QUEUE_DEFAULT_VALUE).resolve();
	}

	@Override
	public String getOnmouseover() {
		return new PropertyResolver<String>(this, "onmauseover")
				.fieldValue(super.getOnmouseover())
				.defaultValue(ON_MOUSE_OVER_DEFAULT_VALUE).resolve();
	}

	@Override
	public String getOnmouseout() {
		return new PropertyResolver<String>(this, "onmouseout")
				.fieldValue(super.getOnmouseover())
				.defaultValue(ON_MOUSE_OUT_DEFAULT_VALUE).resolve();
	}

	@Override
	public String getImage() {
		if (getImageToken() != null)
			super.setImage("/img/btn/" + getImageLevel()
					+ getImageToken()
					+ (isDisabled() ? "disablede.gif" : "e.gif"));

		return super.getImage();
	}

	public String getImageToken() {
		return new PropertyResolver<String>(this, "imageToken").fieldValue(
				_imageToken).resolve();
	}

	public void setImageToken(String _imageToken) {
		this._imageToken = _imageToken;
	}

	public String getImageLevel() {
		return new PropertyResolver<String>(this, "imageLevel")
				.fieldValue(_imageLevel)
				.defaultValue(IMAGE_LEVEL_DEFAULT_VALUE).resolve();
	}

	public void setImageLevel(String _imageLevel) {
		this._imageLevel = _imageLevel;
	}

	@Override
	public FacesContext getFacesContext() {
		return super.getFacesContext();
	}

	@Override
	public Object saveState(FacesContext context) {
		Object[] state = new Object[3];
		state[0] = super.saveState(context);
		state[1] = _imageLevel;
		state[2] = _imageToken;
		return state;
	}

	@Override
	public void restoreState(FacesContext context, Object state) {
		Object[] states = (Object[]) state;
		super.restoreState(context, states[0]);
		_imageLevel = (String) states[1];
		_imageToken = (String) states[2];
	}

}
