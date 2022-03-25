package listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class SuiteListener implements ISuiteListener {

    private static final String ZIPPED_FILE = "screenshots.zip";
    private static List<String> filesListInDir = new ArrayList<>();

    @Override
    public void onStart(ISuite iSuite) {
        File dir = new File(TestListener.SOURCE_FOLDER);
        deleteDir(dir);
    }

    @Override
    public void onFinish(ISuite iSuite) {
        zipFiles(TestListener.SOURCE_FOLDER);
    }

    private void zipFiles(String filePath) {
        File dir = new File(filePath);
        if (dir.exists() && dir.list().length > 0) {
            zipDirectory(dir, filePath + ZIPPED_FILE);
        }
    }

    private static void populateFilesList(File dir) {
        File[] files = dir.listFiles();
        if (files!=null){
            for (File file : files) {
                if (file.isFile())
                    filesListInDir.add(file.getAbsolutePath());
                else populateFilesList(file);
            }
        }
    }

    private static void zipDirectory(File dir, String zipDirName) {
        try {
            populateFilesList(dir);
            FileOutputStream fos = new FileOutputStream(zipDirName);
            ZipOutputStream zos = new ZipOutputStream(fos);
            for (String filePath : filesListInDir) {
                ZipEntry ze = new ZipEntry(filePath.substring(dir.getAbsolutePath().length() + 1, filePath.length()));
                zos.putNextEntry(ze);
                FileInputStream fis = new FileInputStream(filePath);
                byte[] buffer = new byte[1024];
                int len;
                while ((len = fis.read(buffer)) > 0) {
                    zos.write(buffer, 0, len);
                }
                zos.closeEntry();
                fis.close();
            }
            zos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (String aChildren : children) {
                boolean success = deleteDir(new File(dir, aChildren));
                if (!success) {
                    return false;
                }
            }
        }
        return dir.delete();
    }
}
