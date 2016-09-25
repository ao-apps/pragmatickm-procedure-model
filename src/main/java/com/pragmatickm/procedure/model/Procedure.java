/*
 * pragmatickm-procedure-model - Procedures nested within SemanticCMS pages and elements.
 * Copyright (C) 2014, 2015, 2016  AO Industries, Inc.
 *     support@aoindustries.com
 *     7262 Bull Pen Cir
 *     Mobile, AL 36695
 *
 * This file is part of pragmatickm-procedure-model.
 *
 * pragmatickm-procedure-model is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * pragmatickm-procedure-model is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with pragmatickm-procedure-model.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.pragmatickm.procedure.model;

import static com.aoindustries.util.StringUtility.nullIfEmpty;
import com.semanticcms.core.model.Element;

/**
 * Procedures are step-by-step instructions on how to carry out a specific type
 * of task.  Procedure objects are short-lived, within the scope of a single request and,
 * consequently, a single thread.  They do not need to be thread safe.
 */
public class Procedure extends Element {

	private String label;

	@Override
	public Procedure freeze() {
		super.freeze();
		return this;
	}

	@Override
	public String getLabel() {
		synchronized(lock) {
			return label;
		}
	}

	public void setLabel(String label) {
		synchronized(lock) {
			checkNotFrozen();
			this.label = nullIfEmpty(label);
		}
	}

	@Override
	protected String getDefaultIdPrefix() {
		return "procedure";
	}
}
