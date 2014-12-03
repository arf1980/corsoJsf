package com.lenzi.fra.corsoJsf.components;

import javax.el.ValueExpression;
import javax.faces.context.FacesContext;

public interface FraUiComponent {

	public FacesContext getFacesContext();

	public ValueExpression getValueExpression(String name);
}