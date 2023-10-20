package com.giffing.bucket4j.spring.boot.starter.context.properties;

import java.time.temporal.ChronoUnit;

import io.micrometer.common.util.StringUtils;
import jakarta.validation.constraints.*;

import com.giffing.bucket4j.spring.boot.starter.context.RefillSpeed;

import lombok.Data;

/**
 * Configures the rate of data which should be transfered
 *
 */
@Data
public class BandWidth {

	private String id;

	public void setId(String id) {
		if(!StringUtils.isBlank(id)){
			this.id = id.trim();
		}
	}

	@Positive
	private long capacity;

	@Min(1)
	private Long refillCapacity;
	
	@Positive
	private long time;
	
	@NotNull
	private ChronoUnit unit;
	
	@Min(1)
	private Long initialCapacity;
	
	@NotNull
	private RefillSpeed refillSpeed = RefillSpeed.GREEDY;
	
}
