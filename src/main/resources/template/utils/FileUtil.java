${copyright}

package com.accenture.digital.common.utils;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author alan.yang.zhang
 *
 */

@Component
public class FileUtil {

	private static transient Log logger = LogFactory.getLog(FileUtil.class);

	public static void download(String path, String imageURL) {
		try {
			String fullPath = getDataFolderDirPath() + path;

			URL url = new URL(imageURL);

			DataInputStream dataInputStream = new DataInputStream(url.openStream());

			FileOutputStream fileOutputStream = new FileOutputStream(new File(fullPath));

			ByteArrayOutputStream output = new ByteArrayOutputStream();

			byte[] buffer = new byte[1024];
			int length;

			while ((length = dataInputStream.read(buffer)) > 0) {
				output.write(buffer, 0, length);
			}

			byte[] context = output.toByteArray();

			fileOutputStream.write(output.toByteArray());

			IOUtils.closeQuietly(dataInputStream);
			IOUtils.closeQuietly(fileOutputStream);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getCompanyFolder(long companyId) {
		String folderPath = "/" + companyId;

		File folderDir = getFolderDir(folderPath);

		if (folderDir.exists()) {
			return folderPath;
		}
		else {
			return null;
		}
	}

	public static String getAccountFolder(long companyId, long accountId) {
		String folderPath = getCompanyFolder(companyId) + "/" + accountId;

		File folderDir = getFolderDir(folderPath);

		if (folderDir.exists()) {
			return folderPath;
		}
		else {
			return null;
		}
	}

	public static String getQRFolder(long companyId, long accountId) {
		String folderPath = getAccountFolder(companyId, accountId) + "/QRCODE";

		File folderDir = getFolderDir(folderPath);

		if (folderDir.exists()) {
			return folderPath;
		}
		else {
			return null;
		}
	}

	public static String getQRPermanentFolder(long companyId, long accountId) {
		String folderPath = getQRFolder(companyId, accountId) + "/PERMANENT";

		File folderDir = getFolderDir(folderPath);

		if (folderDir.exists()) {
			return folderPath;
		}
		else {
			return null;
		}
	}

	public static String getQRTemporaryFolder(long companyId, long accountId) {
		String folderPath = getQRFolder(companyId, accountId) + "/TEMPORARY";

		File folderDir = getFolderDir(folderPath);

		if (folderDir.exists()) {
			return folderPath;
		}
		else {
			return null;
		}
	}

	public static String createTempFileName(String parentsDir) {
		String fileName = parentsDir + "/" + createTempFileName(null ,"jpg");

		return fileName;
	}

	public static String createTempFileName(String prefix, String extension) {
		StringBuilder sb = new StringBuilder();

		if (prefix != null && !prefix.equals("")) {
			sb.append(prefix);
		}

		sb.append(System.currentTimeMillis());
		sb.append(getRandomKey(8));

		if (extension != null && !extension.equals("")) {
			sb.append(".");
			sb.append(extension);
		}

		return sb.toString();
	}

	public static String getRandomKey(int length) {
		String str = "zxcvbnmlkjhgfdsaqwertyuiopQWERTYUIOPASDFGHJKLZXCVBNM1234567890";

		Random random = new Random();

		StringBuffer sb = new StringBuffer(length);

		for (int i = 0; i < length; i++) {
			int number = random.nextInt(62);

			sb.append(str.charAt(number));
		}

		return sb.toString();
	}

	/**
	 * 创建文件 级联创建
	 * 
	 * @param filePath
	 *			需创建的文件目录路径
	 */
	public static File createFile(final String filePath) {
		try {
			File file = new File(filePath);

			if (file.exists()) {
				logger.info(filePath + "文件已存在");
			} else {
				if (!file.getParentFile().exists()) {
					if (!file.getParentFile().mkdirs()) {
						logger.error(filePath + "文件创建失败！");
					}
				}

				logger.info(filePath + "文件不存在，尝试创建");

				if (!file.createNewFile()) {
					logger.error(filePath + "文件创建失败，请确认路径存在,磁盘没有写保护并且空件足够");
					System.exit(1);
				}

				logger.info(filePath + "创建成功");
			}

			return file;
		} catch (Exception e) {
			System.err.println("文件创建发生异常");
			logger.error(filePath + "文件创建发生异常");
			logger.error(e.getMessage());

			return null;
		}
	}

	public static boolean deleteFile(File file) {
		if (file.exists()) {
			return file.delete();
		}

		return true;
	}

	/**
	 * 删除指定文件夹及其子文件
	 * 
	 * @param fileDir
	 *			需删除的文件夹路径
	 */
	public static void delAllFiles(final String fileDir) {
		// 指定删除目录路径构造一个文件对象
		File file = new File(fileDir);
		File[] fileList = file.listFiles();
		// 初始化子目录路径
		String dirPath = null;
		if (fileList != null) {
			for (int i = 0; i < fileList.length; i++) {
				// 如果是文件就将其删除
				if (fileList[i].isFile()) {
					if (!fileList[i].delete()) {
						logger.error(fileList[i].getName() + "文件删除失败");
					}
				}
				// 如果是目录,那么将些目录下所有文件删除后再将其目录删除,
				if (fileList[i].isDirectory()) {
					dirPath = fileList[i].getPath();
					// 递归删除指定目录下所有文件
					delAllFiles(dirPath);
				}
			}
		}
		// 删除给定根目录
		if (file.delete()) {
			logger.info(fileDir + "目录下的文件删除成功");
		}
	}

	public static File getFolderDir(String path) {
		String fullPath = getDataFolderDirPath() + path;

		File file = new File(fullPath);

		if (!file.exists()) {
			file.mkdirs();
		}

		return file;
	}

	public static File getDataFolderDir() {
		File file = new File(dataFolderDirPath);

		if (!file.exists()) {
			file.mkdirs();
		}

		return file;
	}

	public static String getDataFolderDirPath() {
		return dataFolderDirPath;
	}

	@Value("${data.folder.path}")
	public void setDataFolderDirPath(String dataFolderDirPath) {
		FileUtil.dataFolderDirPath = dataFolderDirPath;
	}

	public static String dataFolderDirPath;

	public static File getFile(String imagePath) {
		String fullPath = getDataFolderDirPath() + imagePath;

		File file = new File(fullPath);

		return file;
	}
}
