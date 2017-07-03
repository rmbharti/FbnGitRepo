package com.fbn.lcm.scalingpolicy;

import java.util.Map;

public interface ScalingPolicy{
	public boolean execute(String serviceId, Map metrics);
}