package com.lenzi.fra.corsoJsf.components;

import javax.el.ELException;
import javax.el.ValueExpression;
import javax.faces.FacesException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PropertyResolver<T> {

	private static final Log log = LogFactory.getLog(PropertyResolver.class);

	private PreparedResolver preparedResolver;

	public PropertyResolver(FraUiComponent uiComponent, String attributeName) {
		preparedResolver = new PreparedResolver();
		preparedResolver.uiComponent = uiComponent;
		preparedResolver.attributeName = attributeName;
	}

	public PreparedResolver fieldValue(T fieldValue) {
		preparedResolver.fieldValue = fieldValue;
		return preparedResolver;
	}

	public class PreparedResolver {
		private FraUiComponent uiComponent;
		private String attributeName;
		private T fieldValue;
		private T defaultvalue;

		private PreparedResolver() {
		}

		public PreparedResolver defaultValue(T defaultValue) {
			this.defaultvalue = defaultValue;
			return this;
		}

		public T resolve() {
			if (attributeName == null) {
				log.error("cannot resolve null attributeName.");
				return null;
			}
			return (T) getPropertyValue(fieldValue, attributeName, defaultvalue);
		}

		@SuppressWarnings("unchecked")
		private T getPropertyValue(T fieldValue, String name, T defaultValue) {
			if (fieldValue != null) {
				return fieldValue;
			}
			ValueExpression valueExpression = uiComponent
					.getValueExpression(name);
			if (valueExpression != null) {
				T value = null;

				try {
					value = (T) valueExpression.getValue(uiComponent
							.getFacesContext().getELContext());
				} catch (ELException e) {
					throw new FacesException(e);
				}

				return value;
			}

			return defaultValue;
		}
	}
}
