/*
 * Copyright 2019 The original author or authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package server;

import reactor.core.publisher.Mono;
import reactor.netty.DisposableServer;
import reactor.netty.http.HttpProtocol;
import reactor.netty.http.server.HttpServer;
import util.Host;
import util.Port;

import java.util.concurrent.CountDownLatch;

public class Server {
	public static void main(String[] args) {
		if (args.length > 2) {
			System.out.println("Too many arguments");
			System.exit(-1);
		}

		DisposableServer server =
			HttpServer.create()
				.protocol(HttpProtocol.H2C)
				.host(Host.getHost(args))
				.port(Port.getPort(args))
				.handle((req, res) -> res.sendString(Mono.just("Hello")))
				.wiretap(true)
				.bindNow();

		try {
			new CountDownLatch(1).await();
		} catch (InterruptedException e) {
		}

		server.disposeNow();
	}
}
