package com.example.weather.config;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.weather.api.WeatherUpdateJob;

@Configuration
public class QuartzConfig {
	
	@Bean
    public JobDetail weatherUpdateJobDetail() {
        return JobBuilder.newJob(WeatherUpdateJob.class)
                .withIdentity("weatherUpdateJob")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger weatherUpdateJobTrigger() {
        return TriggerBuilder.newTrigger()
                .forJob(weatherUpdateJobDetail())
                .withIdentity("weatherUpdateTrigger")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 */3 * * * ?")) // Run every 3 minutes
                .build();
    }

}
