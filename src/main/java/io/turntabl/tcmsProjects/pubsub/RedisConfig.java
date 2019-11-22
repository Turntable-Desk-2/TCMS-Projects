package io.turntabl.tcmsProjects.pubsub;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public class RedisConfig {
    public static void redisConfiguration() {
        Jedis jedis = new Jedis(System.getenv("REDIS_URL"));
        try {
            JedisPubSub jedisPubSub = new JedisPubSub() {
                @Override
                public void onMessage(String channel, String message) {
                    System.out.println("Channel: " + channel + " Message: " + message);
                }

                @Override
                public void onSubscribe(String channel, int subscribedSchannels) {
                    System.out.println("Subscribed to: " + channel);
                }

            };
            jedis.ping();
            jedis.subscribe(jedisPubSub, "projects", "new_project", "update", "remove");
            jedis.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
