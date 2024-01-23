package com.krawart.hexademo.common.domain;

import java.util.UUID;

/**
 * Abstract base class for local entities. If local identity is used for the local entities, this class will contain
 * code for managing that. Otherwise, it may just be an empty marker class
 */
public interface LocalEntity extends Entity<UUID> {}
