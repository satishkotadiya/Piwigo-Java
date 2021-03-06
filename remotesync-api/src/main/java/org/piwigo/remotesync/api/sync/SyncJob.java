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
package org.piwigo.remotesync.api.sync;

import java.io.IOException;

import org.piwigo.remotesync.api.ISyncConfiguration;
import org.piwigo.remotesync.api.Job;
import org.piwigo.remotesync.api.conf.ConfigurationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SyncJob extends Job {

	private static final Logger logger = LoggerFactory.getLogger(SyncJob.class);

	protected void doExecute() throws Exception {
		ISyncConfiguration syncConfiguration = ConfigurationUtil.INSTANCE.getUserConfiguration().getCurrentSyncConfiguration();

		// TODO shoud validate config
		// SyncConfigurationValidator.INSTANCE.validate(syncConfiguration);

		logger.info("User {} will sync gallery {} with directory {}", syncConfiguration.getUsername(), syncConfiguration.getUrl(), syncConfiguration.getDirectory());

		try {
			new ConnectedWalker(syncConfiguration).walk();
		} catch (IOException e) {
			logger.error("Error in sync", e);
		}

		logger.info("Finished");
	}
}
