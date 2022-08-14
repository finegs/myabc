package net.myabc.spring.batch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class PersonExtractScheduler {

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private Job job;

	/**
     *                    ┌───────────── second (0-59)
     *                    │ ┌───────────── minute (0 - 59)
     *                    │ │ ┌───────────── hour (0 - 23)
     *                    │ │ │ ┌───────────── day of the month (1 - 31)
     *                    │ │ │ │ ┌───────────── month (1 - 12) (or JAN-DEC)
     *                    │ │ │ │ │ ┌───────────── day of the week (0 - 7)
     *                    │ │ │ │ │ │          (or MON-SUN -- 0 or 7 is Sunday)
     *                    │ │ │ │ │ │
     *                    * * * * * *
	 */
	@Scheduled(cron = "*/10 * * * * *")
	public void myScheduler() {
		JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
				.toJobParameters();

		try {
			JobExecution jobExecution = jobLauncher.run(job, jobParameters);
			System.out.println("Job's Status:::" + jobExecution.getStatus());
		} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
				| JobParametersInvalidException e) {
			e.printStackTrace();
		}
	}
}