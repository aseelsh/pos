/**
 * Copyright (C) 2023 multiPOS, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
 
package cloud.multipos.pos.net

import cloud.multipos.pos.Pos
import cloud.multipos.pos.util.*

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.BroadcastReceiver 
import android.net.wifi.WifiManager



class Network (val listener: NetworkListener) {

	 init {
	 
		  Post ("pos/status")
				.add (Jar ())
				.exec (fun (result: Jar): Unit {
							  
							  Logger.x ("post result... ${result}")

							  if (result.getInt ("status") == 0) {

									listener.onSuccess ()
							  }
							  else {

									listener.onFail ()
							  }
						 }
				)
	 }
}
