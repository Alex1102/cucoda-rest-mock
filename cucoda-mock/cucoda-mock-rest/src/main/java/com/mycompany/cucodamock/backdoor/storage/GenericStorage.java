package com.mycompany.cucodamock.backdoor.storage;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class GenericStorage<K, V> {

	private final Cache<K, V> cache = CacheBuilder.newBuilder()
			.expireAfterAccess(2, TimeUnit.HOURS)
			.build();

	public Set<K> getIds() {
		// keys is not serializable, we have to use an old hash container
		Set<K> keys = cache.asMap().keySet();
		return new HashSet<>(keys);
	}

	public V get(K key) {
		V valueIfPresent = cache.getIfPresent(key);
		if (valueIfPresent != null) {
			return valueIfPresent;
		} else {
			throw new RuntimeException("MisConfigured Mock: Storage does not contain any value for key " + key);
		}

	}

	public void put(K key, V value) {
		cache.put(key, value);
	}
}
