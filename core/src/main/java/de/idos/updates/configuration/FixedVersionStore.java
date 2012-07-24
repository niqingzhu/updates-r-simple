package de.idos.updates.configuration;

import de.idos.updates.Version;
import de.idos.updates.VersionStore;
import de.idos.updates.store.DataInVersion;

import java.io.File;

public class FixedVersionStore implements VersionStore {
    private File rootFolder;
    private VersionStore wrapped;

    public FixedVersionStore(File rootFolder, VersionStore wrapped) {
        this.rootFolder = rootFolder;
        this.wrapped = wrapped;
    }

    @Override
    public void addVersion(Version version) {
        wrapped.addVersion(version);
    }

    @Override
    public void addContent(Version version, DataInVersion dataInVersion) {
        wrapped.addContent(version, dataInVersion);
    }

    @Override
    public void removeOldVersions() {
        wrapped.removeOldVersions();
    }

    @Override
    public void removeVersion(Version version) {
        wrapped.removeVersion(version);
    }

    @Override
    public Version getLatestVersion() {
        return wrapped.getLatestVersion();
    }

    @Override
    public File getFolderForVersionToRun() {
        return rootFolder;
    }
}