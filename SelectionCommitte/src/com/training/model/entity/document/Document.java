package com.training.model.entity.document;



public class Document {
	private final DocumentType type;

	 Document(DocumentType type) {
		this.type = type;
	}
	public DocumentType getType(){
		return type;
	}
	@Override
	public String toString() {
		return "Document [type=" + type + "]";
	}
	
}