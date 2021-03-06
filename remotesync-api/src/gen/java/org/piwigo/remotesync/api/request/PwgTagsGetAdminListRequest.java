/*******************************************************************************
 * Copyright (c) 2014 Matthieu Helleboid.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *     Matthieu Helleboid - initial API and implementation
 ******************************************************************************/
package org.piwigo.remotesync.api.request;

import org.piwigo.remotesync.api.request.AbstractRequest;
import org.piwigo.remotesync.api.response.PwgTagsGetAdminListResponse;

/**
<b>Admin only.</b>
**/
@org.piwigo.remotesync.generator.Generated
public class PwgTagsGetAdminListRequest extends AbstractRequest<PwgTagsGetAdminListResponse> {

	public PwgTagsGetAdminListRequest() {
	}

	public boolean isNeedPwgToken() {
		return false;
	}

	public boolean isAdminOnly() {
		return true;
	};

	public boolean isPostOnly() {
		return false;
	};

	public String getWSMethodName() {
		return "pwg.tags.getAdminList";
	}

	public Class<PwgTagsGetAdminListResponse> getReturnType() {
		return PwgTagsGetAdminListResponse.class;
	}
}
