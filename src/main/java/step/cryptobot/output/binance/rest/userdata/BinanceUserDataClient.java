package step.cryptobot.output.binance.rest.userdata;

import reactor.core.publisher.Mono;

public interface BinanceUserDataClient {

    /**
     * Start a new user data stream.
     * Endpoint: POST /api/v3/userDataStream
     *
     * @return Mono emitting the listenKey for the user data stream.
     */
    Mono<String> startUserDataStream();

    /**
     * Keepalive a user data stream to prevent timeout.
     * Endpoint: PUT /api/v3/userDataStream
     *
     * @param listenKey the listen key of the stream to be kept alive.
     * @return Mono signaling when the keepalive request has completed.
     */
    Mono<Void> keepAliveUserDataStream(String listenKey);

    /**
     * Close a user data stream.
     * Endpoint: DELETE /api/v3/userDataStream
     *
     * @param listenKey the listen key of the stream to be closed.
     * @return Mono signaling when the close request has completed.
     */
    Mono<Void> closeUserDataStream(String listenKey);
}
