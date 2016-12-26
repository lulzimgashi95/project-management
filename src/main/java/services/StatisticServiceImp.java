package services;

import models.Statistic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import rowMappers.StatisticRowMapper;
import sql.HomeSQL;

/**
 * Created by LulzimG on 24/12/16.
 */
@Service("statisticService")
public class StatisticServiceImp implements StatisticService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Statistic getStatistic() {
        Statistic statistic;
        try {
            statistic = this.jdbcTemplate.queryForObject(HomeSQL.STATISTICS, new StatisticRowMapper());
        } catch (Exception e) {
            return null;
        }
        return statistic;
    }
}
