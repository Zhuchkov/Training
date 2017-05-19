package com.training.model.entity.document;

import java.util.Random;

public class DocumentFactory {
	private int mathCreated = 0;
	private int biologCreated = 0;
	private Random random = new Random();

	public Document getRandomDocument() {
		if (mathCreated < DocumentType.MATH.getQuantity() && biologCreated < DocumentType.MATH.getQuantity()) {
			return createRandom();
		} else if (mathCreated < DocumentType.MATH.getQuantity()) {
			return createMath();
		} else if (biologCreated < DocumentType.BIOLOG.getQuantity()) {
			return createBiolog();
		}
		return null;
	}

	private Document createRandom() {
		DocumentType typeOption = DocumentType.values()[random.nextInt(DocumentType.values().length)];
		if (typeOption == DocumentType.MATH) {
			return createMath();
		} else {
			return createBiolog();
		}
	}

	private Document createMath() {
		mathCreated++;
		Document document = new Document(DocumentType.MATH);
		return document;
	}

	private Document createBiolog() {
		biologCreated++;
		Document document = new Document(DocumentType.BIOLOG);
		return document;
	}

}
