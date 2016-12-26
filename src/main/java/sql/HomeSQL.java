package sql;

/**
 * Created by LulzimG on 24/12/16.
 */
public class HomeSQL {
    public static final String STATISTICS = "SELECT COUNT(DISTINCT p.id) as projects,COUNT(DISTINCT m.id) as members,COUNT(DISTINCT s.id) as sponsors,COUNT(DISTINCT n.id) as notes FROM projects p  LEFT JOIN members m ON p.id = m.project_id AND m.active=1 LEFT JOIN sponsors s ON p.id = s.project_id AND s.active=1 LEFT JOIN notes n ON p.id = n.project_id AND n.active=1  WHERE p.active=1;";
}
