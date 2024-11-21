package com.springmvc.lc.propertyeditor;

import java.beans.PropertyEditorSupport;

public class MyNamePropertyEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) {

		setValue(text.toUpperCase());
	}
}
