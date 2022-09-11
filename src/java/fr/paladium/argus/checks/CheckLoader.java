package fr.paladium.argus.checks;

import fr.paladium.argus.checks.ACheck;
import fr.paladium.argus.checks.id.CheckHWID;
import fr.paladium.argus.checks.id.CheckNetworkInterfaces;
import fr.paladium.argus.checks.id.CheckRealIp;
import fr.paladium.argus.checks.id.CheckUsername;
import fr.paladium.argus.checks.jvm.CheckDynamicLibs;
import fr.paladium.argus.checks.jvm.CheckEnvVariables;
import fr.paladium.argus.checks.jvm.CheckHeapDump;
import fr.paladium.argus.checks.jvm.CheckKeepAlive;
import fr.paladium.argus.checks.jvm.CheckOperatingSystem;
import fr.paladium.argus.checks.jvm.CheckProcesses;
import fr.paladium.argus.checks.jvm.CheckProcesses2;
import fr.paladium.argus.checks.jvm.CheckTrace;
import fr.paladium.argus.checks.jvm.CheckVirtualMachine;
import fr.paladium.argus.checks.kernel.CheckAttachedModules;
import fr.paladium.argus.checks.minecraft.CheckAltSession;
import fr.paladium.argus.checks.minecraft.CheckAutoclick;
import fr.paladium.argus.checks.minecraft.CheckBlockOpacity;
import fr.paladium.argus.checks.minecraft.CheckMCExists;
import fr.paladium.argus.checks.minecraft.CheckMCVariables;
import fr.paladium.argus.checks.minecraft.CheckPalaMods;
import fr.paladium.argus.checks.minecraft.CheckPalaSolo;
import fr.paladium.argus.checks.minecraft.CheckZip;
import fr.paladium.argus.connection.login.InternalSession;
import java.util.ArrayList;
import java.util.List;

public class CheckLoader {
    private final InternalSession session;

    public CheckLoader(InternalSession session) {
        this.session = session;
    }

    public List<ACheck> loadChecks() {
        ArrayList<ACheck> checks = new ArrayList<ACheck>();
        checks.add(new CheckKeepAlive(this.session));
        checks.add(new CheckHWID(this.session));
        checks.add(new CheckTrace(this.session));
        checks.add(new CheckDynamicLibs(this.session));
        checks.add(new CheckHeapDump(this.session));
        checks.add(new CheckAttachedModules(this.session));
        checks.add(new CheckVirtualMachine(this.session));
        checks.add(new CheckProcesses(this.session));
        checks.add(new CheckProcesses2(this.session));
        checks.add(new CheckAutoclick(this.session));
        checks.add(new CheckAltSession(this.session));
        checks.add(new CheckOperatingSystem(this.session));
        checks.add(new CheckRealIp(this.session));
        checks.add(new CheckUsername(this.session));
        checks.add(new CheckMCExists(this.session));
        checks.add(new CheckPalaMods(this.session));
        checks.add(new CheckMCVariables(this.session));
        checks.add(new CheckZip(this.session));
        checks.add(new CheckBlockOpacity(this.session));
        checks.add(new CheckEnvVariables(this.session));
        checks.add(new CheckPalaSolo(this.session));
        checks.add(new CheckNetworkInterfaces(this.session));
        return checks;
    }
}
